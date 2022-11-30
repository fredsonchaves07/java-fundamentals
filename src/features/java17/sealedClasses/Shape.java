package features.java17.sealedClasses;

public sealed class Shape permits Rectangle, Circle {

}

sealed class Rectangle extends Shape {}

non-sealed class Circle extends Shape {}

final class Square extends Rectangle{}
