package ru.vsu.cs.cg.task4_demo;


import ru.vsu.cs.cg.task4_demo.draw.IDrawer;
import ru.vsu.cs.cg.task4_demo.draw.EdgeGraphicsDrawer;
import ru.vsu.cs.cg.task4_demo.math.Vector3;
import ru.vsu.cs.cg.task4_demo.models.Parallelepiped;
import ru.vsu.cs.cg.task4_demo.models.SomeModel;
import ru.vsu.cs.cg.task4_demo.models.Square;
import ru.vsu.cs.cg.task4_demo.screen.ScreenConverter;
import ru.vsu.cs.cg.task4_demo.third.Camera;
import ru.vsu.cs.cg.task4_demo.third.IModel;
import ru.vsu.cs.cg.task4_demo.third.PolyLine3D;
import ru.vsu.cs.cg.task4_demo.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel implements CameraController.RepaintListener {
    Random random = new Random();
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;
    private java.util.List<Square> squares = new ArrayList<>();

    public DrawPanel() {
        super();
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.WHITE.getRGB());
//        scene.getModelsList().add(new Parallelepiped(new Vector3(0, 0, 0), new Vector3(2.5f, 2.5f, 2.5f)));
        scene.getModelsList().add(new SomeModel());

        Voxelization(scene.getModelsList().get(0), 2.8f);
        System.out.println(squares.size());

        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    public float[] extremePoints(IModel model) {
        float[] exPMax = new float[]{0, 0, 0};
        float[] exPMin = new float[]{0, 0, 0};
        for (PolyLine3D p : model.getLines()) {
            for (Vector3 v : p.getPoints()) {
                if (v.getX() > exPMax[0]) {
                    exPMax[0] = v.getX();
                }
                if (v.getX() < exPMin[0]) {
                    exPMin[0] = v.getX();
                }

                if (v.getY() > exPMax[1]) {
                    exPMax[1] = v.getY();
                }
                if (v.getY() < exPMin[1]) {
                    exPMin[1] = v.getY();
                }

                if (v.getZ() > exPMax[2]) {
                    exPMax[2] = v.getZ();
                }
                if (v.getZ() < exPMin[2]) {
                    exPMin[2] = v.getZ();
                }
            }
        }
        float[] exP = new float[6];
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                exP[i] = exPMin[i];
            } else {
                exP[i] = exPMax[i - 3];
            }
        }
        return exP;
    }

    public void Voxelization(IModel model, float side) {
        float[] exP = extremePoints(model);

        for (float x = exP[0] + side / 2f; x <= exP[3] - side / 2f; x += side) {
            for (float y = exP[1] + side / 2f; y <= exP[4] - side / 2f; y += side) {
                for (float z = exP[2] + side / 2f; z <= exP[5] - side / 2f; z += side) {
                    Square square = new Square(new Vector3(x, y, z), side);
                    scene.getModelsList().add(square);
                    squares.add(square);
                }
            }
        }


        for (Square s : squares) {

        }

    }

    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        IDrawer dr = new EdgeGraphicsDrawer(sc, graphics);
        scene.drawScene(dr, cam);
        g.drawImage(bi, 0, 0, null);
        graphics.dispose();

    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
