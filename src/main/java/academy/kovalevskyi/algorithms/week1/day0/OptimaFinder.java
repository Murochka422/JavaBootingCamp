package academy.kovalevskyi.algorithms.week1.day0;

import java.util.function.Function;

public class OptimaFinder {
  public static double findOptima(Function<Double, Double> f, double start,
                                  double end, double precision) {
    if ((end - start) < precision) {
      return start;
    }
    double optima = start + (end - start) / 2;
    double nearLeft = f.apply(optima - precision);
    double nearRight = f.apply(optima + precision);
    if (nearLeft < nearRight) {
      optima = findOptima(f, start, optima, precision);
    } else if (nearLeft > nearRight) {
      optima = findOptima(f, optima, end, precision);
    } else {
      if (f.apply(start) < f.apply(end)) {
        optima = findOptima(f, start, optima, precision);
      } else {
        optima = findOptima(f, optima, end, precision);
      }
    }
    return optima;
  }
}
