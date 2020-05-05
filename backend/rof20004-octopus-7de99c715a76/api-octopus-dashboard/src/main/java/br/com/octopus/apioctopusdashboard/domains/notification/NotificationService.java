package br.com.octopus.apioctopusdashboard.domains.notification;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octopus.apioctopusdashboard.domains.question.Question;
import br.com.octopus.apioctopusdashboard.exceptions.NotificationException;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	public NotificationDTO create(NotificationDTO dto) throws NotificationException {
		validateNotification(dto);

		Notification notification = Notification.builder().question(new Question(dto.getQuestionId())).timestamp(LocalDateTime.now()).build();
		notificationRepository.save(notification);

		dto.setId(notification.getId());

		return dto;
	}

	private void validateNotification(NotificationDTO dto) throws NotificationException {
		if (dto == null) {
			throw new NotificationException("É obrigatório informar a notificação");
		}

		validateNotificationQuestionId(dto.getQuestionId());
	}
	
	private void validateNotificationQuestionId(Long questionId) throws NotificationException {
		if (questionId == null) {
			throw new NotificationException("É obrigatório informar o id da pergunta");
		}
	}

}
