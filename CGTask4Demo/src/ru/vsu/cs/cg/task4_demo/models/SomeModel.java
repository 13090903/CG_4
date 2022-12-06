package ru.vsu.cs.cg.task4_demo.models;

import ru.vsu.cs.cg.task4_demo.math.Vector3;
import ru.vsu.cs.cg.task4_demo.third.IModel;
import ru.vsu.cs.cg.task4_demo.third.PolyLine3D;

import java.util.LinkedList;
import java.util.List;


/**
 * Описывает параллелипипед по двум диагональным точкам
 */
public class SomeModel implements IModel {
    private List<Vector3> points = new LinkedList<>();
    private List<PolyLine3D> lines = new LinkedList<>();

    public SomeModel() {
        for (int i = 0; i < 10; i++) {
            for (double u = 0; u <= 2 * Math.PI; u += Math.PI/5) {
                double x = Math.cos(u)*i;
                double y = Math.sin(u)*i;
                double z = i;
                points.add(new Vector3((float) x, (float) y, (float) z));
            }
        }
    }


    @Override
    public List<PolyLine3D> getLines() {
        if (lines.size() == 0) {
            List<PolyLine3D> testLines = new LinkedList<>();
            testLines.add(new PolyLine3D(points, false));
            return testLines;
        } else {
            return lines;
        }
    }
}
