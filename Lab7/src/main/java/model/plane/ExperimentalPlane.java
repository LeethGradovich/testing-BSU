package model.plane;

import model.type.ClassificationLevel;
import model.type.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType type;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model,
                             int maxSpeed,
                             int maxFlightDistance,
                             int maxLoadCapacity,
                             ExperimentalType type,
                             ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (classificationLevel != null ? classificationLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "type=" + type +
                ", classificationLevel=" + classificationLevel +
                "} " + super.toString();
    }
}
