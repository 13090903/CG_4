package ru.vsu.cs.cg.task4_demo.models;

import ru.vsu.cs.cg.task4_demo.math.Vector3;
import ru.vsu.cs.cg.task4_demo.third.IModel;
import ru.vsu.cs.cg.task4_demo.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Square implements IModel {
    private Vector3 center;
    private float side;

    public Square(Vector3 center, float side) {
        this.center = center;
        this.side = side;
    }

    /*Триангулированный куб*/
//    @Override
//    public List<PolyLine3D> getLines() {
//        LinkedList<PolyLine3D> lines = new LinkedList<>();
//        /*Дальняя сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2)), true));
//        /*Ближняя сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2)), true));
//
//        /*Правая сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2)), true));
//        /*Левая сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2)), true));
//        /*Нижняя сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2),
//                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
//                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2)), true));
//
//        /*Верхняя сторона*/
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2),
//                new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2)), true));
//        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2),
//                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2)), true));
//
//        return lines;
//    }


    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        /*Дальняя сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2),
                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2)), true));
        /*Ближняя сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2),
                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2)), true));

        /*Правая сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
                new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2),
                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2)), true));
        /*Левая сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2),
                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2)), true));
        /*Нижняя сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() + side/2),
                new Vector3(center.getX() + side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() - side/2),
                new Vector3(center.getX() - side/2, center.getY() - side/2, center.getZ() + side/2)), true));

        /*Верхняя сторона*/
        lines.add(new PolyLine3D(Arrays.asList(new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() + side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() + side/2),
                new Vector3(center.getX() - side/2, center.getY() + side/2, center.getZ() - side/2),
                new Vector3(center.getX() + side/2, center.getY() + side/2, center.getZ() - side/2)), true));

        return lines;
    }

    public Vector3 getCenter() {
        return center;
    }

    public float getSide() {
        return side;
    }

    public void setCenter(Vector3 center) {
        this.center = center;
    }

    public void setSide(float side) {
        this.side = side;
    }
}

