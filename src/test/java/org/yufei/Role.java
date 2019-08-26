
package org.yufei;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类的说明放这里
 * </p>
 * <p>
 * copyright featherfly 2010-2020, all rights reserved.
 * </p>
 *
 * @author 钟冀
 */
public class Role {

    private Role() {
    }

    private String name = "admin";
    private User user;
    private Person person;
    private Person[] persons;
    private List<Person> personList;
    private Map<String, Person> personMap;
    private Actor actor;
    private Actor[] actors;
    private List<Actor> actorList;

    /**
     * 返回actorList
     *
     * @return actorList
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * 返回actors
     *
     * @return actors
     */
    public Actor[] getActors() {
        return actors;
    }

    /**
     * 返回actor
     *
     * @return actor
     */
    public Actor getActor() {
        return actor;
    }

    /**
     * 返回user
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    /**
     * 返回person
     *
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * 返回persons
     *
     * @return persons
     */
    public Person[] getPersons() {
        return persons;
    }

    /**
     * 返回personList
     *
     * @return personList
     */
    public List<Person> getPersonList() {
        return personList;
    }

    /**
     * 返回personMap
     *
     * @return personMap
     */
    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Role [name=" + name + ", user=" + user + ", person=" + person + ", persons=" + Arrays.toString(persons)
                + ", personList=" + personList + ", personMap=" + personMap + ", actor=" + actor + ", actors="
                + Arrays.toString(actors) + ", actorList=" + actorList + "]";
    }

    public static void main(String[] args) throws SecurityException, NoSuchFieldException {
        Field f = Role.class.getDeclaredField("personList");
        System.out.println(f.getGenericType());

        Type type = f.getGenericType();

        System.out.println(((ParameterizedType) type).getActualTypeArguments()[0]);

        System.out.println(type instanceof ParameterizedType);

        System.out.println();

        f = Role.class.getDeclaredField("personLists");
        System.out.println(f.getGenericType());
        type = f.getGenericType();

        System.out.println(type instanceof ParameterizedType);

        System.out.println(((ParameterizedType) type).getActualTypeArguments()[0]);
    }

}
