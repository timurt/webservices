package kz.tim.samples.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Class required to enable Jax-Rs and specify relative path for rest services.
 *
 * @author Timur Tibeyev.
 */

@ApplicationPath("/rest")
public class RestApplication extends Application {
}
