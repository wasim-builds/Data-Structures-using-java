# 🔗 System Design: URL Shortener (e.g., TinyURL)

## 1. Requirements
**Functional Requirements:**
- Given a long URL, return a much shorter, unique alias.
- When users click the short URL, they are redirected to the original long URL.
- Links expire after a certain timespan.

**Non-Functional Requirements:**
- Highly available (if the service goes down, millions of links break).
- Fast redirection (minimal latency).

## 2. Capacity Estimation
- **Traffic**: 100 million new URLs generated per day. 1 billion redirections per day.
- **Read/Write Ratio**: 10:1 (heavily read-intensive).
- **Storage**: 100M URLs/day * 365 days * 5 years * 500 bytes per URL = ~90 Terabytes.

## 3. The Core Logic (Base62 Encoding)
To make a short URL, we need a unique ID for every long URL. 
- We can use a 7-character string. 
- Characters allowed: [A-Z, a-z, 0-9] = 62 possible characters.
- Total combinations: 62^7 = **3.5 Trillion unique URLs**!

We use a **Ticket Server** (like a MySQL auto-incrementing database) to generate a unique integer ID. We then convert that Base-10 integer into a Base-62 string.

## 4. High-Level Architecture
1. **Client** sends long URL.
2. **Load Balancer** routes request to Web Server.
3. **Web Server** asks the **Ticket Server** for a unique integer ID.
4. Server converts ID to Base62 string (e.g., `aBc12X`).
5. Server saves mapping `[aBc12X -> https://verylong.com/...]` in the database.
6. Returns `http://tiny.url/aBc12X` to the user.

## 5. Database & Caching
- **Database**: We can use **DynamoDB** or **Cassandra** (NoSQL) because we only need simple Key-Value lookups, and they scale horizontally effortlessly.
- **Cache**: **Redis** or **Memcached**. Since 20% of URLs generate 80% of the traffic (Pareto Principle), we should cache the most popular URLs in memory to guarantee sub-millisecond redirection!
