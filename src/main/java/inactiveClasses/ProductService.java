package inactiveClasses;

import inactiveClasses.Product;

import java.util.Collection;

public interface ProductService {

    public abstract void createProduct(Product product);
    public abstract void updateProduct(Integer Id, Product product);
    public abstract void deleteProduct(Integer Id);
    public abstract Collection<Product> getProducts();
}
// Method 1: java.net.HttpURLConnection
        /*
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appid=" + city.getApiKey1());
            connection = (HttpURLConnection) url.openConnection();


            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connection Control
            int status = connection.getResponseCode();
            // --> System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                System.out.println("--> Data from the first city:");
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        System.out.println();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city2 + "&appid=" + city.getApiKey1());
            connection = (HttpURLConnection) url.openConnection();

            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connection Control
            int status = connection.getResponseCode();
            // --> System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                System.out.println("--> Data from the second city:");
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        */