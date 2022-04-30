package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_TAG", schema = "PUBLIC", catalog = "TEST")
public class CaTagEntity {
    private int tagId;
    private Object tagName;
    private int tagRef;
    private Object field;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "TAG_NAME")
    public Object getTagName() {
        return tagName;
    }

    public void setTagName(Object tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "TAG_REF")
    public int getTagRef() {
        return tagRef;
    }

    public void setTagRef(int tagRef) {
        this.tagRef = tagRef;
    }

    @Basic
    @Column(name = "FIELD")
    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaTagEntity that = (CaTagEntity) o;
        return tagId == that.tagId && tagRef == that.tagRef && Objects.equals(tagName, that.tagName) && Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagName, tagRef, field);
    }
}
