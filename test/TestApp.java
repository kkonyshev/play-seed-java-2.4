import controllers.Application;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

/**
 * https://www.playframework.com/documentation/2.4.0-RC3/JavaTest
 * https://www.playframework.com/documentation/2.1.0/JavaJsonRequests
 * Created by konishev on 12/02/2016.
 */
public class TestApp extends WithApplication {
  @Test
  public void testIndexGet() {
    Result result = new Application().index();
    assertEquals(OK, result.status());
    assertEquals(Http.MimeTypes.JSON, result.contentType());
    assertEquals("foobar", Json.parse(contentAsString(result)).findPath("stringFiled").asText());


  }
}
