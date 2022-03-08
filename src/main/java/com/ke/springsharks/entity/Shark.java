package com.ke.springsharks.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class Shark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	@Min(2)
	@Max(20)
	private int age;

	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private String habitat;
	
	@Column
	private String gender;

	public Shark() {}

	public Shark(@Min(2) @Max(20) int age, String name, String habitat, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.habitat = habitat;
		this.gender = gender;
	}

	public Shark(long id, @Min(2) @Max(20) int age, String name, String habitat, String gender) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.habitat = habitat;
		this.gender = gender;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	 //
	@Override
	public String toString() {
		return "Shark [id=" + id + ", age=" + age + ", name=" + name + ", habitat=" + habitat + ", gender=" + gender
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, habitat, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(habitat, other.habitat)
				&& id == other.id && Objects.equals(name, other.name);
	}
}