package powx_n;

public class Solution {
    public double pow(double x, int n) {
        if (n > 0){
            return helper(x,n);
        }else {
            return 1.0/helper(x,n);
        }
    }

    private double helper(double x, int n){
        if (n == 0)
            return 1;
        double y = helper(x,n/2);
        if (n % 2 == 0){
            return y*y;
        }else {
            return y*y*x;
        }
    }
}
