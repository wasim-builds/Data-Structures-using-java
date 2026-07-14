# 🎬 System Design: Netflix (Video Streaming Service)

## 1. Requirements
**Functional Requirements:**
- Users can watch videos (movies, TV shows).
- High availability (the system cannot go down).
- Scalable (supports millions of concurrent users globally).

**Non-Functional Requirements:**
- Low latency (videos must start playing instantly without buffering).
- High Reliability.

## 2. Capacity Estimation
- **Traffic**: Assume 100 million active users.
- **Data Storage**: Millions of videos stored in different resolutions (SD, HD, 4K). We need Petabytes of storage.
- **Bandwidth**: Extremely high outbound bandwidth required.

## 3. High-Level Architecture
### Components:
1. **Client**: The web, mobile, or smart TV app.
2. **API Gateway / Load Balancer**: Distributes incoming traffic across microservices.
3. **Open Connect (CDN)**: *This is the most critical part of Netflix's architecture!* Videos are not streamed from AWS. They are cached locally on ISP servers (Internet Service Providers) worldwide. When you click play, you stream the video from a server physically located in your city.
4. **AWS Cloud (Control Plane)**: Handles everything that *isn't* streaming (Login, Search, Recommendations, Billing).
5. **Transcoding Service**: When a movie is uploaded, it is converted into hundreds of different formats and resolutions so it can play on any device at varying internet speeds.

## 4. Database Design
- **Cassandra (NoSQL)**: Used for storing viewing history. It is highly available and write-optimized (since millions of people are constantly pausing/playing).
- **MySQL (RDBMS)**: Used for billing and user account management where ACID compliance is strictly required.
- **Elasticsearch**: Used for the search bar to find movies instantly.

## 5. Handling Failure
- **Chaos Engineering**: Netflix uses a tool called *Chaos Monkey* that randomly shuts down servers in production to ensure the system is truly fault-tolerant and highly available!
