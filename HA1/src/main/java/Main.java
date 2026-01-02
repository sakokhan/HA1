public class Main {
    public static void main(String[] args){
        //задача 1
        int b = 12;
        int c = 85;
        int a = 4*(b+c-1)/2;
        System.out.println(a);


        //задача 2
        int n = 35;
        int x = (n/10);
        int y = n%10;
        int z = x+y;
        System.out.println(z);

        //задача 3 упростила задачку по рекомендации
        int m = 859;
        int e = m/100;
        int r = m%10;
        int j = (m%100)/10;
        int p = e+j+r;
        System.out.println(p);

        //задача 4 исправила ошибку
        double num = 458.569;
        double num1 = num+0.5;
        System.out.println((int)num1);

        //задача 5
        int q = 59;
        int w = 4;
        int v =59/4;
        int k = 59%4;
        System.out.println(q + " / " + w + " = " + v + " и " + k + " в остатке.");

        //задача *
        int l = 1;
        int h = 2;
        int f = l;
        l = h;
        h = f;
        System.out.println(l);
        System.out.println(h);

//        задача * внесла правки
        int u = 1;
        int i = 2;
        u = u + i;
        i = u - i;
        u = u - i;
        System.out.println(u);
        System.out.println(i);


    }
}
