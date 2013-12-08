package helloworld;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Component("helloBean")
@Scope("session")
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 5306205251332638378L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
