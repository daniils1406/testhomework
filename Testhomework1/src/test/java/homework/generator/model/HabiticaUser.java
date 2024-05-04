package homework.generator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class HabiticaUser {
    @XmlElement(name = "username", required = true)
    private String userName;
    @XmlElement(name = "password", required = true)
    private String password;
    @XmlElement(name = "baseurl", required = true)
    private String baseUrl;

    public HabiticaUser(String userName, String password) {
        this(userName, password, "https://habitica.com");
    }
}
