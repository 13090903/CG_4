package ru.vsu.cs.cg.task4_demo.draw;

import ru.vsu.cs.cg.task4_demo.math.Vector3;
import ru.vsu.cs.cg.task4_demo.screen.ScreenConverter;
import ru.vsu.cs.cg.task4_demo.screen.ScreenCoordinates;
import ru.vsu.cs.cg.task4_demo.screen.ScreenPoint;
import ru.vsu.cs.cg.task4_demo.third.PolyLine3D;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Реализация рисователя полигонов с помощью рёбер.
 */
public class EdgeGraphicsDrawer extends AbstractGraphicsDrawer {
    public EdgeGraphicsDrawer(ScreenConverter sc, Graphics2D g) {
        super(sc, g);
    }

    /**
     * Рисует одну полилинию на графиксе.
     *
     * @param polyline полилиния
     */
    @Override
    protected void oneDraw(PolyLine3D polyline) {
        LinkedList<ScreenPoint> points = new LinkedList<>();
        /*переводим все точки в экранные*/
        for (Vector3 v : polyline.getPoints())
            points.add(getScreenConverter().r2s(v));
        getGraphics().setColor(Color.BLACK);
        /*если точек меньше двух, то рисуем отдельными алгоритмами*/
        if (points.size() < 2) {
            if (points.size() > 0)
                getGraphics().fillRect(points.get(0).getI(), points.get(0).getJ(), 1, 1);
            return;
        }
        /*создаём хранилище этих точек в виде двух массивов*/
        ScreenCoordinates crds = new ScreenCoordinates(points);
        /*если линия замкнута - рисуем полигон, иначе - полилинию*/
        getGraphics().setColor(Color.BLACK);
        if (polyline.isClosed()) {
            getGraphics().drawPolygon(crds.getXx(), crds.getYy(), crds.size());
            getGraphics().setColor(new Color(12, 66, 149, 20));
            getGraphics().fillPolygon(crds.getXx(), crds.getYy(), crds.size());
        }
        else
            getGraphics().drawPolyline(crds.getXx(), crds.getYy(), crds.size());
    }

    /**
     * В данной реализации возвращаем фильтр, который одобряет все полилинии.
     *
     * @return фильтр полилиний
     */
    @Override
    protected IFilter<PolyLine3D> getFilter() {
        return new IFilter<PolyLine3D>() {
            @Override
            public boolean accept(PolyLine3D line) {
                return true;
            }
        };
    }

    /**
     * Сравниваем полилинии по-среднему Z.
     *
     * @return компаратор
     */
    @Override
    protected Comparator<PolyLine3D> getComparator() {
        return new Comparator<PolyLine3D>() {
            private static final float EPSILON = 1e-8f;

            @Override
            public int compare(PolyLine3D a, PolyLine3D b) {
                float d = b.avgZ() - a.avgZ();
                if (-EPSILON < d && d < EPSILON)
                    return 0;
                return d < 0 ? -1 : 1;
            }
        };
    }

}
