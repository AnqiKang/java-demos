package algorithmWithLeetcode.hash;

/**
 * In data structure Hash, hash function is used to convert a string(or any other type)
 * into an integer smaller than hash size and bigger or equal to zero.
 * The objective of designing a hash function is to "hash" the key as unreasonable as possible.
 * A good hash function can avoid collision as less as possible.
 * A widely used hash function algorithm is using a magic number 33,
 */

public class HashFunctionLT128 {
    public static void main(String[] args) {
        String str = "abcd";
        char[] key = str.toCharArray();
        int size = 1000;
        int res = hashCode(key, size);
        System.out.println(res);


    }

    public static int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length < 1) {
            return Integer.MIN_VALUE;
        }
        // (a * 33^3+ b * 33^2 + c * 33^1 + d * 33^0) % HASH_SIZE
        // --> 先把之前的数*33 再加上当前的数，再取模。不停的 乘
        // （(a * 33 + b) * 33 + c * 33) + d
        // 这样最前面的数 乘以 33 的次数就最多


        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (ans * 33 + (int) (key[i])) % HASH_SIZE;
        }
        return (int) ans;
    }

}
