package hammertank.jackson.inherit;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class UseExternalProperty {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Circle circle = new Circle();
        circle.setRadius(1.0);
        Table table = new Table();
        table.setShape(circle);

        String jsonStr = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(table);
        System.out.println(jsonStr);
        Table deserialized = mapper.readValue(jsonStr, Table.class);
    }

    public static class Shape {
        private int edgeNum;

        public Shape(int edgeNum) {
            this.edgeNum = edgeNum;
        }

        public int getEdgeNum() {
            return edgeNum;
        }

        public void setEdgeNum(int edgeNum) {
            this.edgeNum = edgeNum;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle() {
            super(1);
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }

    public static class Triangle extends Shape {
        private double[] edges;

        public Triangle() {
            super(3);
        }

        public double[] getEdges() {
            return edges;
        }

        public void setEdges(double[] edges) {
            this.edges = edges;
        }
    }

    public static class Table {

        @JsonTypeInfo(
                use = JsonTypeInfo.Id.NAME,
                include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
                property = "type"
        )
        @JsonSubTypes({
                @JsonSubTypes.Type(value = Circle.class, name = "circle"),
                @JsonSubTypes.Type(value = Triangle.class, name = "triangle")
        })
        private Shape shape;

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }
    }
}
