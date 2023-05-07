import java.util.Random;

public class RandomNumberGenerator {
    
    public static float rand_uint(){
        return (new Random()).nextFloat();
    }

    public static float rand_range(double min, double max){
        return (float)(rand_uint() * (max - min) + min);
    }

    public static float rand_exponential(double mean){
        return (float)(-1 * mean * Math.log(rand_uint()));
    }

}
