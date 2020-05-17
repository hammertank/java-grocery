package hammertank.jackson.inherit;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class UseExistingProperty {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Circle circle = new Circle();
        circle.setRadius(1.0);
        Triangle triangle = new Triangle();
        triangle.setEdges(new double[]{3, 4, 5});
        Shapes shapes = new Shapes();
        shapes.setShapes(Arrays.asList(circle, triangle));

        String jsonStr = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(shapes);
        System.out.println(jsonStr);
        Shapes deserialized = mapper.readValue(jsonStr, Shapes.class);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXISTING_PROPERTY,
            property = "edgeNum"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Circle.class, name = "1"),
            @JsonSubTypes.Type(value = Triangle.class, name = "3")
    })
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

    public static class Shapes {
        private List<Shape> shapes;

        public List<Shape> getShapes() {
            return shapes;
        }

        public void setShapes(List<Shape> shapes) {
            this.shapes = shapes;
        }
    }
}
