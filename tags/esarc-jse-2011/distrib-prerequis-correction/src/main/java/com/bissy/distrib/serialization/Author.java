package com.bissy.distrib.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Author implements Serializable, Externalizable {

    private transient long id;
    private String lastName;
    private String firstName;

    public Author() {}
    
    public Author(long id, String firstName, String lastName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		firstName = in.readLine();
		lastName = in.readLine();
		id = in.readLong();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.write((firstName+"\n").getBytes());
		out.write((lastName+"\n").getBytes());
		out.writeLong(id);
	}
    

}
