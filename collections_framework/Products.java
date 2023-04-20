import java.util.ArrayList;
import java.util.HashMap;

public class Products{
	public String name;
	public double price;
	public int quantity;


	public Products(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

}


class generateProducts{
	public static void main(String[] args){
		ArrayList<Products> products = new ArrayList<Products>();
		Products pen = new Products("pen",2,200);
		Products pen2 = new Products("pen",1,100);
		Products cup = new Products("cup",5,100);
		Products book = new Products("Book",20,40);
		Products book2 = new Products("Book",30,40);

		products.add(pen);
		products.add(pen2);
		products.add(cup);
		products.add(book);
		products.add(book2);

		HashMap<String, Products> productMap = new HashMap<>();
		for (Products product: products){
			if(productMap.containsKey(product.name)){
				// Get quantity from hasmap
				int mapQty = productMap.get(product.name).quantity;
				
				// compare quantities
				if( mapQty < product.quantity){
					productMap.put(product.name,product);
				}

			} else{
				productMap.put(product.name,product);
			}
		}

		for (Products currentProduct:  productMap.values()){
			System.out.println("Product name is : " + currentProduct.name + " Product Price is: " + currentProduct.price + " Product Quantity is: " + currentProduct.quantity );
		}

	}
}