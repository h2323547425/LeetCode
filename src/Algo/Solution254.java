package Algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as the product of their factors.
 *
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 * Given an integer n, return all possible combinations of its factors.
 * You may return the answer in any order.
 *
 * Note that the factors should be in the range [2, n - 1].
 */
public class Solution254 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        getFactorsHelper(n, 2, result, new ArrayList<>());
        return result;
    }

    public void getFactorsHelper(int product, int factor,
                                 List<List<Integer>> result, List<Integer> factorization) {
        if (factorization.size() > 0) {
            factorization.add(product);
            result.add(new ArrayList<>(factorization));
            factorization.remove(factorization.size() - 1);
        }
        for (int i = factor; i*i <= product; i++) {
            if (product % i == 0) {
                factorization.add(i);
                getFactorsHelper(product / i, i, result, factorization);
                factorization.remove(factorization.size() - 1);
            }
        }
    }

}
