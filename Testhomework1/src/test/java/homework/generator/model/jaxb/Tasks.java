package homework.generator.model.jaxb;

import homework.generator.model.HabiticaTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks {

    @XmlElement(name = "task")
    private List<HabiticaTask> tasks;
}
