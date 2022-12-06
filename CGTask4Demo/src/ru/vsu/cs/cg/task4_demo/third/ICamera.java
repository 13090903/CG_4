package ru.vsu.cs.cg.task4_demo.third;

import ru.vsu.cs.cg.task4_demo.math.Vector3;

/**
 * Описывает основную функциональность камеры - превращение координат
 * из мировой системы координат в систему координат камеры.
 */
public interface ICamera {
    /**
     * Преобразует точку из мировой системы координат в систему координат камеры
     * @param v преобразуемая точка
     * @return новая точка
     */
    public Vector3 w2s(Vector3 v);
}
