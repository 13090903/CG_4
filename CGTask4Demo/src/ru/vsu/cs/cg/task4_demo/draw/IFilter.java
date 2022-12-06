package ru.vsu.cs.cg.task4_demo.draw;

/**
 * Интерфейс декларирует метод, который будет отвечать, подходит ли заданный экземпляр класса какому-либо условию
 */
public interface IFilter<T> {
    boolean accept(T value);
}

