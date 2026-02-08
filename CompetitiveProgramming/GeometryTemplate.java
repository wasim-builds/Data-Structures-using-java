package CompetitiveProgramming;

/**
 * Geometry Basics Template for Competitive Programming
 
 * Contains basic geometry functions:
 * - Point and Vector operations
 * - Distance calculations
 * - Area calculations
 * - Line operations
 * - Convex hull basics
 */
public class GeometryTemplate {

    static final double EPS = 1e-9;

    // ==================== Point Class ====================

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Distance to another point
        double distanceTo(Point other) {
            double dx = x - other.x;
            double dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        // Manhattan distance
        double manhattanDistance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // ==================== Vector Operations ====================

    static class Vector {
        double x, y;

        Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        Vector(Point from, Point to) {
            this.x = to.x - from.x;
            this.y = to.y - from.y;
        }

        // Magnitude (length)
        double magnitude() {
            return Math.sqrt(x * x + y * y);
        }

        // Dot product
        double dot(Vector other) {
            return x * other.x + y * other.y;
        }

        // Cross product (z-component in 2D)
        double cross(Vector other) {
            return x * other.y - y * other.x;
        }

        // Normalize (unit vector)
        Vector normalize() {
            double mag = magnitude();
            return new Vector(x / mag, y / mag);
        }

        // Angle between vectors (in radians)
        double angleTo(Vector other) {
            return Math.acos(dot(other) / (magnitude() * other.magnitude()));
        }
    }

    // ==================== Distance Functions ====================

    // Euclidean distance
    public static double distance(Point p1, Point p2) {
        return p1.distanceTo(p2);
    }

    // Distance from point to line segment
    public static double distanceToSegment(Point p, Point a, Point b) {
        Vector ap = new Vector(a, p);
        Vector ab = new Vector(a, b);

        double t = ap.dot(ab) / ab.dot(ab);
        t = Math.max(0, Math.min(1, t)); // Clamp to [0, 1]

        Point closest = new Point(a.x + t * ab.x, a.y + t * ab.y);
        return p.distanceTo(closest);
    }

    // ==================== Area Calculations ====================

    // Area of triangle using coordinates
    public static double triangleArea(Point a, Point b, Point c) {
        return Math.abs((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y)) / 2.0;
    }

    // Area of polygon using shoelace formula
    public static double polygonArea(Point[] points) {
        int n = points.length;
        double area = 0;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += points[i].x * points[j].y;
            area -= points[j].x * points[i].y;
        }

        return Math.abs(area) / 2.0;
    }

    // Area of circle
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // ==================== Line Operations ====================

    // Check if three points are collinear
    public static boolean areCollinear(Point a, Point b, Point c) {
        Vector ab = new Vector(a, b);
        Vector ac = new Vector(a, c);
        return Math.abs(ab.cross(ac)) < EPS;
    }

    // Check if point is on line segment
    public static boolean isOnSegment(Point p, Point a, Point b) {
        if (!areCollinear(a, b, p))
            return false;
        return p.x >= Math.min(a.x, b.x) && p.x <= Math.max(a.x, b.x) &&
                p.y >= Math.min(a.y, b.y) && p.y <= Math.max(a.y, b.y);
    }

    // Check if two line segments intersect
    public static boolean segmentsIntersect(Point a1, Point a2, Point b1, Point b2) {
        Vector v1 = new Vector(a1, a2);
        Vector v2 = new Vector(b1, b2);
        Vector v3 = new Vector(a1, b1);
        Vector v4 = new Vector(a1, b2);

        double cross1 = v1.cross(v3);
        double cross2 = v1.cross(v4);

        Vector v5 = new Vector(b1, a1);
        Vector v6 = new Vector(b1, a2);

        double cross3 = v2.cross(v5);
        double cross4 = v2.cross(v6);

        if (cross1 * cross2 < 0 && cross3 * cross4 < 0) {
            return true;
        }

        // Check for collinear cases
        if (Math.abs(cross1) < EPS && isOnSegment(b1, a1, a2))
            return true;
        if (Math.abs(cross2) < EPS && isOnSegment(b2, a1, a2))
            return true;
        if (Math.abs(cross3) < EPS && isOnSegment(a1, b1, b2))
            return true;
        if (Math.abs(cross4) < EPS && isOnSegment(a2, b1, b2))
            return true;

        return false;
    }

    // ==================== Orientation ====================

    // Returns: 0 = collinear, 1 = clockwise, 2 = counterclockwise
    public static int orientation(Point a, Point b, Point c) {
        Vector ab = new Vector(a, b);
        Vector ac = new Vector(a, c);
        double cross = ab.cross(ac);

        if (Math.abs(cross) < EPS)
            return 0; // Collinear
        return cross > 0 ? 2 : 1; // CCW : CW
    }

    // ==================== Convex Hull (Graham Scan) ====================

    public static Point[] convexHull(Point[] points) {
        int n = points.length;
        if (n < 3)
            return points;

        // Find bottom-most point (or left-most if tie)
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].y < points[minIdx].y ||
                    (points[i].y == points[minIdx].y && points[i].x < points[minIdx].x)) {
                minIdx = i;
            }
        }

        // Swap to first position
        Point temp = points[0];
        points[0] = points[minIdx];
        points[minIdx] = temp;

        final Point pivot = points[0];

        // Sort by polar angle
        java.util.Arrays.sort(points, 1, n, (p1, p2) -> {
            int o = orientation(pivot, p1, p2);
            if (o == 0) {
                return Double.compare(pivot.distanceTo(p1), pivot.distanceTo(p2));
            }
            return o == 2 ? -1 : 1;
        });

        // Build hull
        java.util.Stack<Point> hull = new java.util.Stack<>();
        hull.push(points[0]);
        hull.push(points[1]);
        hull.push(points[2]);

        for (int i = 3; i < n; i++) {
            while (hull.size() > 1) {
                Point top = hull.pop();
                Point nextToTop = hull.peek();
                if (orientation(nextToTop, top, points[i]) != 1) {
                    hull.push(top);
                    break;
                }
            }
            hull.push(points[i]);
        }

        return hull.toArray(new Point[0]);
    }

    // ==================== Demo ====================

    public static void main(String[] args) {
        System.out.println("=== Distance ===");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        System.out.println("Distance: " + p1.distanceTo(p2)); // 5.0

        System.out.println("\n=== Triangle Area ===");
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 3);
        System.out.println("Area: " + triangleArea(a, b, c)); // 6.0

        System.out.println("\n=== Orientation ===");
        System.out.println("Orientation: " + orientation(a, b, c)); // 2 (CCW)

        System.out.println("\n=== Vector Operations ===");
        Vector v1 = new Vector(3, 4);
        System.out.println("Magnitude: " + v1.magnitude()); // 5.0
    }
}
