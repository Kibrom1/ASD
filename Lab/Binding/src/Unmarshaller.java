import java.io.File;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Unmarshaller {
	public static void main(String args[]) {
		marshaller();
		unMarshaller();

	}

	private static void marshaller() {
		JAXBContext context;
		Product product = new Product("Kebede", "Hagos", BigDecimal.valueOf(400.00));
		try {
			context = JAXBContext.newInstance(Product.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Product object = new Product();

			object.setCode("WI1");

			object.setName("Widget Number One");

			object.setPrice(BigDecimal.valueOf(300.00));
			object.setProduct(product);

			m.marshal(object, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void unMarshaller() {
		try {

			JAXBContext jc = JAXBContext.newInstance(Product.class);

			javax.xml.bind.Unmarshaller u = jc.createUnmarshaller();

			File f = new File("product.xml");

			Product product = (Product) (u).unmarshal(f);
			System.out.println(product.getCode());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getProduct().getCode());

		} catch (JAXBException e) {

			e.printStackTrace();

		}

	}
}
