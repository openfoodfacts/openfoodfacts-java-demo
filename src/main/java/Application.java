import pl.coderion.model.ProductResponse;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

public class Application {

  public static void main(String[] args) {
    OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
    ProductResponse productResponse = wrapper.fetchProductByCode("737628064502");
    System.out.println(productResponse);
  }
}
