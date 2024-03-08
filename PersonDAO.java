package com.example.crud_persona.DAO;

import com.example.crud_persona.Models.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Persona> personas;
    private static int PEOPLE_COUNT;

    {
        personas = new ArrayList<>();
        personas.add(new Persona(++PEOPLE_COUNT, "Tom",24,"maxnisks.mail.ru"));
        personas.add(new Persona(++PEOPLE_COUNT, "Mik",67,"sjncjsnc.mail.ru"));
        personas.add(new Persona(++PEOPLE_COUNT, "Lilo",12,"jahxaujhx.mail.ru"));
        personas.add(new Persona(++PEOPLE_COUNT, "Tim",22,"jabxywlaa.mail.ru"));
        personas.add(new Persona(++PEOPLE_COUNT, "Kiko",88,"ksxjalalala.mail.ru"));
    }

    public List<Persona> index() {
        return personas;
    }

    public Persona show(int id) {
        return personas.stream().filter(persona -> persona.getId() == id).findAny().orElse(null);
    }

    public void save(Persona persona) {
        persona.setId(++PEOPLE_COUNT);
        personas.add(persona);
    }

    public void update(int id, Persona persona) {
        Persona persona1 = show(id); //находим человека которого хотим изменить
        persona1.setName(persona.getName()); //добавляем ему новое имя пришедшее из формы
        persona1.setAge(persona.getAge());
        persona1.setEmail(persona.getEmail());
    }
    public void delete(int id){
        personas.removeIf(persona -> persona.getId() == id);
    }
}
