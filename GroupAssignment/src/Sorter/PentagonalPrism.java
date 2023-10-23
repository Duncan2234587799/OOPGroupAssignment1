package Sorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author me
 */
public class PentagonalPrism extends Shape3D {
    private double height;
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        super(height);
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return (5.0 / 4) * edgeLength * edgeLength * (1 / Math.tan(Math.PI / 5));
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return "PentagonalPrism:" + "height=" + height + ", edgeLength=" + edgeLength;
    }

   
}
