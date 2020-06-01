package swaps.components;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/*
 * Simple HttpRequest class that sends a POST request to the specified url and port.
 * Currently data is set to be of type application/json in the header.
 *
 * This class can easily be modified to send any other kind of http request and uses Apache's Http Client.
 * Refer to Apache Doc for more information about the used imports.
 *
 * @author   Christopher Glissner
 */
public class HttpRequest {
    private HttpResponse response;

    /*
     * Class Constructor
     *
     * Configures and sends the HTTP Request
     *
     * @param url    destination URI to request is sent to
     * @param port   open port at the given URI
     * @param data   json object
     */
    public HttpRequest(String url, int port, String data) throws URISyntaxException {
        try {
            URI address = new URI("http", null, url, port, "", "id=10", "anchor");
            HttpPost request = new HttpPost(address);
            request.addHeader("content-type", "application/json");
            HttpEntity httpEntity = new StringEntity(data);
            request.setEntity(httpEntity);
            HttpClient httpClient = HttpClientBuilder.create().build();
            this.response = httpClient.execute(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     *   getResponse() function and returns the Response as InputStream
     *
     *   @return     response as InputStream
     */
    public InputStream getResponse() throws IOException {
        return this.response.getEntity().getContent();
    }

    /*
     *   getResponse() function and returns the Response as HttpResponse
     *
     *   @return     response as HttpResponse
     */
    public HttpResponse getResponseAsHttpResponse() {
        return this.response;
    }

    /*
     *   getBody() function and returns the Response's Body as String
     *
     *   @return     response as HttpResponse
     */
    public String getBody() throws IOException {
        ResponseHandler<String> handler = new BasicResponseHandler();

        return handler.handleResponse(response);
    }
}
