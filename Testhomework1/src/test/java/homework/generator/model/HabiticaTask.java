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
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class HabiticaTask {
    @XmlElement(name = "name", required = true)
    private String name;
}
