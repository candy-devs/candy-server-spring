package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_TAG", schema = "PUBLIC", catalog = "TEST")
public class CaTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    private long tagId;
    @Basic
    @Column(name = "TAG_NAME")
    private String tagName;
    @Basic
    @Column(name = "TAG_REF")
    private int tagRef;
    @Basic
    @Column(name = "FIELD")
    private String field;

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagRef() {
        return tagRef;
    }

    public void setTagRef(int tagRef) {
        this.tagRef = tagRef;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
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
