import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.addProduct(new Product("A" , 1));


        System.out.format(" Enter a double value - \n");
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        catalog.getTotalCombinationCount(x);
        System.out.println();
        catalog.getTotalCombinationCountDynamically(x);
    }
}


class Product {
    String name;
    double price;
    Product( String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return this.name + " , " + this.price;
    }
}

class Catalog
{
    List<Product> products;
    Catalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct( Product p)
    {
        products.add(p);
    }

    public void getTotalCombinationCount(double totalPrice)
    {
        List<List<Product>> AllCombinationLists = new ArrayList<>();
        List<Product> temporaryList = new ArrayList<>();

        System.out.format(" total combinations = %s\n", getAllCombinationHelper(AllCombinationLists, temporaryList, 0 , totalPrice));
        System.out.println();
        for(List<Product> list : AllCombinationLists)
        {
            System.out.println(list);
        }
    }

    public void getTotalCombinationCountDynamically(double totalPrice)
    {
        List<List<Product>> AllCombinationLists = getAllCombinationsDynamically(products,  totalPrice);
        System.out.format(" total combinations dynamically = %s\n", AllCombinationLists.size());

        System.out.println();
        for(List<Product> list : AllCombinationLists)
        {
            System.out.println(list);
        }
    }

    public int getAllCombinationHelper(List<List<Product>> AllCombinationLists, List<Product> temporaryList, int offset, double totalPrice)
    {
       if(totalPrice == 0 && offset == products.size() )
        {
            AllCombinationLists.add(new ArrayList<>(temporaryList));
            return 1;
        }

        if(offset >= products.size())
        {
            return 0;
        }

        int sum = 0;
        Product p = products.get(offset);

        temporaryList.add(p);
        sum += getAllCombinationHelper(AllCombinationLists, temporaryList, offset + 1, totalPrice - p.price);
        temporaryList.remove(temporaryList.size() - 1);
        sum += getAllCombinationHelper(AllCombinationLists, temporaryList, offset + 1, totalPrice);
        return sum;
    }


    public List<List<Product>>  getAllCombinationsDynamically(List<Product> products, double totalPrice)
    {
        // dp[i][j] means total combinations with product size of first i elements and double price value of j.
        List<List<Product>> [][] dp = new List[products.size() + 1][(int)totalPrice + 1];
        for(int i = 0; i <= products.size(); i++)
        {
            for(int j = 0; j <= totalPrice; j++) {
                dp[i][j] = new ArrayList<>();
                dp[i][j].add(new ArrayList<>());
            }
            dp[i][0].add(new ArrayList<>());
           // dp[i][0].get(0).add(new Product("", 0));
        }

        for(int i = 1; i <= products.size(); i++)
        {
            for(int j = 1; j <= totalPrice; j++)
            {
                if(products.get(i - 1).price <= j)
                {
                    dp[i][j].addAll(dp[i-1][j]);
                    dp[i][j].addAll(dp[i-1][j - (int)products.get(i - 1).price]);
                    for( List<Product> list : dp[i][j])
                    {
                        list.add(products.get(i - 1));
                    }

                }
                else
                {
                    dp[i][j].addAll(dp[i-1][j]);
                    for( List<Product> list : dp[i][j])
                    {
                        list.add(products.get(i - 1));
                    }
                }
            }
        }
        return dp[products.size()][(int)totalPrice];
    }
}
