package algorithmWithLeetcode.dp.traverse;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean res = canJump(nums);
        System.out.println(res);

    }

    private static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];

        dp[0] = true;


        /**
         *  i 表示往右边走 , j 表示从哪个点跳过来的，
         *  dp[j] == true 表示nums中 j这个位置在之间就被跳到过了， 所以可以在这个j上继续判断
         *  nums[j] 表示 在j的位置上可以跳几步， 并且j从0-i的范围内，只要为true，都是可以被跳到的，依次尝试
         *
         *  i = 1 表示当前走到了1， j = 0； dp[0] = true表示0目前可以到达，
         *  nums[0] + 0 --> 2 + 0表示 从 可跳到的0点还能继续往下走两步。
         *  两步之后如果 >= i 表示，这个i可以被到达。 否则 j++ 再次查看  0-i的范围里这个j是不是可以被跳到
         *  break 跳到i之后不需要继续往下跳，只判断能不能跳到当前i即可。
         */
        for(int i = 1; i < nums.length; i++){
            for(int j = 0;  j <= i; j++ ){
                if(dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    break;

                }
            }
        }
        return dp[nums.length - 1];


    }
}
