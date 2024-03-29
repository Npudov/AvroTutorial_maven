/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.example.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2161252716196523824L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"org.example.avro\",\"fields\":[{\"name\":\"stringField\",\"type\":\"string\"},{\"name\":\"intField\",\"type\":\"int\"},{\"name\":\"listField\",\"type\":{\"type\":\"array\",\"items\":\"int\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<User> ENCODER =
      new BinaryMessageEncoder<User>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<User> DECODER =
      new BinaryMessageDecoder<User>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<User> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<User> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<User>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this User to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a User from a ByteBuffer. */
  public static User fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence stringField;
  @Deprecated public int intField;
  @Deprecated public java.util.List<java.lang.Integer> listField;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public User() {}

  /**
   * All-args constructor.
   * @param stringField The new value for stringField
   * @param intField The new value for intField
   * @param listField The new value for listField
   */
  public User(java.lang.CharSequence stringField, java.lang.Integer intField, java.util.List<java.lang.Integer> listField) {
    this.stringField = stringField;
    this.intField = intField;
    this.listField = listField;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return stringField;
    case 1: return intField;
    case 2: return listField;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: stringField = (java.lang.CharSequence)value$; break;
    case 1: intField = (java.lang.Integer)value$; break;
    case 2: listField = (java.util.List<java.lang.Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'stringField' field.
   * @return The value of the 'stringField' field.
   */
  public java.lang.CharSequence getStringField() {
    return stringField;
  }

  /**
   * Sets the value of the 'stringField' field.
   * @param value the value to set.
   */
  public void setStringField(java.lang.CharSequence value) {
    this.stringField = value;
  }

  /**
   * Gets the value of the 'intField' field.
   * @return The value of the 'intField' field.
   */
  public java.lang.Integer getIntField() {
    return intField;
  }

  /**
   * Sets the value of the 'intField' field.
   * @param value the value to set.
   */
  public void setIntField(java.lang.Integer value) {
    this.intField = value;
  }

  /**
   * Gets the value of the 'listField' field.
   * @return The value of the 'listField' field.
   */
  public java.util.List<java.lang.Integer> getListField() {
    return listField;
  }

  /**
   * Sets the value of the 'listField' field.
   * @param value the value to set.
   */
  public void setListField(java.util.List<java.lang.Integer> value) {
    this.listField = value;
  }

  /**
   * Creates a new User RecordBuilder.
   * @return A new User RecordBuilder
   */
  public static org.example.avro.User.Builder newBuilder() {
    return new org.example.avro.User.Builder();
  }

  /**
   * Creates a new User RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new User RecordBuilder
   */
  public static org.example.avro.User.Builder newBuilder(org.example.avro.User.Builder other) {
    return new org.example.avro.User.Builder(other);
  }

  /**
   * Creates a new User RecordBuilder by copying an existing User instance.
   * @param other The existing instance to copy.
   * @return A new User RecordBuilder
   */
  public static org.example.avro.User.Builder newBuilder(org.example.avro.User other) {
    return new org.example.avro.User.Builder(other);
  }

  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private java.lang.CharSequence stringField;
    private int intField;
    private java.util.List<java.lang.Integer> listField;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.example.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.stringField)) {
        this.stringField = data().deepCopy(fields()[0].schema(), other.stringField);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.intField)) {
        this.intField = data().deepCopy(fields()[1].schema(), other.intField);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.listField)) {
        this.listField = data().deepCopy(fields()[2].schema(), other.listField);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing User instance
     * @param other The existing instance to copy.
     */
    private Builder(org.example.avro.User other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.stringField)) {
        this.stringField = data().deepCopy(fields()[0].schema(), other.stringField);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.intField)) {
        this.intField = data().deepCopy(fields()[1].schema(), other.intField);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.listField)) {
        this.listField = data().deepCopy(fields()[2].schema(), other.listField);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'stringField' field.
      * @return The value.
      */
    public java.lang.CharSequence getStringField() {
      return stringField;
    }

    /**
      * Sets the value of the 'stringField' field.
      * @param value The value of 'stringField'.
      * @return This builder.
      */
    public org.example.avro.User.Builder setStringField(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.stringField = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'stringField' field has been set.
      * @return True if the 'stringField' field has been set, false otherwise.
      */
    public boolean hasStringField() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'stringField' field.
      * @return This builder.
      */
    public org.example.avro.User.Builder clearStringField() {
      stringField = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'intField' field.
      * @return The value.
      */
    public java.lang.Integer getIntField() {
      return intField;
    }

    /**
      * Sets the value of the 'intField' field.
      * @param value The value of 'intField'.
      * @return This builder.
      */
    public org.example.avro.User.Builder setIntField(int value) {
      validate(fields()[1], value);
      this.intField = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'intField' field has been set.
      * @return True if the 'intField' field has been set, false otherwise.
      */
    public boolean hasIntField() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'intField' field.
      * @return This builder.
      */
    public org.example.avro.User.Builder clearIntField() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'listField' field.
      * @return The value.
      */
    public java.util.List<java.lang.Integer> getListField() {
      return listField;
    }

    /**
      * Sets the value of the 'listField' field.
      * @param value The value of 'listField'.
      * @return This builder.
      */
    public org.example.avro.User.Builder setListField(java.util.List<java.lang.Integer> value) {
      validate(fields()[2], value);
      this.listField = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'listField' field has been set.
      * @return True if the 'listField' field has been set, false otherwise.
      */
    public boolean hasListField() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'listField' field.
      * @return This builder.
      */
    public org.example.avro.User.Builder clearListField() {
      listField = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User build() {
      try {
        User record = new User();
        record.stringField = fieldSetFlags()[0] ? this.stringField : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.intField = fieldSetFlags()[1] ? this.intField : (java.lang.Integer) defaultValue(fields()[1]);
        record.listField = fieldSetFlags()[2] ? this.listField : (java.util.List<java.lang.Integer>) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<User>
    WRITER$ = (org.apache.avro.io.DatumWriter<User>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<User>
    READER$ = (org.apache.avro.io.DatumReader<User>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
