package co.gruppo2.studiomedico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService{
    @Autowired
    private IDoctorRepository doctorRepository;
    
}
