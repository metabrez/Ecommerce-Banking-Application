package com.userFront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userFront.dao.AppointmentDao;
import com.userFront.domain.Appointment;
import com.userFront.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentDao.save(appointment);
		
	}

	@Override
	public List<Appointment> findAll() {
		
		return appointmentDao.findAll();
		
	}

	@Override
	public Appointment findAppointment(Long id) {
		
		return appointmentDao.findOne(id);
		
	}

	@Override
	public void confirmAppointment(Long id) {
		Appointment appointment=findAppointment(id);
		appointment.setConfirmed(true);
		appointmentDao.save(appointment);
		
	}

}
