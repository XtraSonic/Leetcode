package dailies.rectangleAreaII;

import java.util.*;

public class RectangleAreaIIApproach1 implements RectangleAreaII {

    @Override
    public int rectangleArea(int[][] rectangles) {
        Blob b = new Blob();
        for (int[] rectangleCoords : rectangles) {
            Rectangle rectangle = new Rectangle(rectangleCoords[0], rectangleCoords[1], rectangleCoords[2], rectangleCoords[3]);
            b.insertRectangle(rectangle);
        }
        return (int) (b.calculateArea() % 1000000007);
    }

    static class Blob {
        PriorityQueue<Rectangle> columnsInStructure = new PriorityQueue<>(Comparator.comparingInt(a -> a.xLow));

        public void insertRectangle(Rectangle rectangle) {
            List<Rectangle> rectanglesToAdd = new LinkedList<>();
            PriorityQueue<Rectangle> orderedColumns = new PriorityQueue<>(columnsInStructure);
            while (!orderedColumns.isEmpty()) {
                Rectangle currentColumn = orderedColumns.poll();
                if (currentColumn.getIntersectionRectangle(rectangle) == null)
                    continue;
                if (rectangle.yLow >= currentColumn.yLow && rectangle.yHigh <= currentColumn.yHigh) {
                    //we do not need to change the current column since the intersection extends on the x axis
                    if (rectangle.xLow < currentColumn.xLow) {
                        rectanglesToAdd.add(new Rectangle(rectangle.xLow, rectangle.yLow, currentColumn.xLow, rectangle.yHigh));
                    }
                    if (rectangle.xHigh > currentColumn.xHigh) {
                        rectangle = new Rectangle(currentColumn.xHigh, rectangle.yLow, rectangle.xHigh, rectangle.yHigh);
                    } else {
                        rectangle = null;
                        break;
                    }
                } else {
                    //we need to modify the current column
                    columnsInStructure.remove(currentColumn);
                    if (rectangle.xLow < currentColumn.xLow) {
                        rectanglesToAdd.add(new Rectangle(rectangle.xLow, rectangle.yLow, currentColumn.xLow, rectangle.yHigh));
                    } else {
                        if (rectangle.xLow > currentColumn.xLow)
                            rectanglesToAdd.add(new Rectangle(currentColumn.xLow, currentColumn.yLow, rectangle.xLow, currentColumn.yHigh));
                    }
                    if (rectangle.xHigh > currentColumn.xHigh) {
                        rectanglesToAdd.add(new Rectangle(
                                rectangle.xLow,
                                Math.min(currentColumn.yLow, rectangle.yLow),
                                currentColumn.xHigh,
                                Math.max(currentColumn.yHigh, rectangle.xHigh)));
                        rectangle = new Rectangle(currentColumn.xHigh, rectangle.yLow, rectangle.xHigh, rectangle.yHigh);
                    } else {
                        rectanglesToAdd.add(new Rectangle(
                                rectangle.xLow,
                                Math.min(currentColumn.yLow, rectangle.yLow),
                                rectangle.xHigh,
                                Math.max(currentColumn.yHigh, rectangle.yHigh)));

                        if (rectangle.xHigh < currentColumn.yHigh)
                            rectanglesToAdd.add(new Rectangle(rectangle.xHigh, currentColumn.yLow, currentColumn.xHigh, currentColumn.yHigh));

                        rectangle = null;
                        break;
                    }
                }
            }

            if (rectangle != null)
                columnsInStructure.add(rectangle);
            columnsInStructure.addAll(rectanglesToAdd);
        }

        long calculateArea() {
            long result = 0;
            for (Rectangle c : columnsInStructure) {
                result += c.getArea();
            }
            return result;
        }
    }

    static class Rectangle {
        int xLow;
        int yLow;
        int xHigh;
        int yHigh;

        public Rectangle(int xLow, int yLow, int xHigh, int yHigh) {
            this.xLow = xLow;
            this.yLow = yLow;
            this.xHigh = xHigh;
            this.yHigh = yHigh;
        }

        public Rectangle getIntersectionRectangle(Rectangle other) {
            if (xLow > other.xHigh || other.xLow > xHigh || yLow > other.yHigh || other.yLow > yHigh)
                return null;
            return new Rectangle(
                    Math.max(xLow, other.xLow),
                    Math.max(yLow, other.yLow),
                    Math.min(xHigh, other.xHigh),
                    Math.min(yHigh, other.yHigh)
            );
        }

        public long getArea() {
            return ((long) xHigh - xLow) * (yHigh - yLow);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return xLow == rectangle.xLow && yLow == rectangle.yLow && xHigh == rectangle.xHigh && yHigh == rectangle.yHigh;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xLow, yLow, xHigh, yHigh);
        }
    }
}
