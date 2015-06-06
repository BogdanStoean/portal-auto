package ro.rocknrolla.portal_auto.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationFailureResponse extends Response {

	private List<FieldError> fieldErrors = new ArrayList<>();
	private List<String> errors = new ArrayList<>();

	public ValidationFailureResponse(Builder builder) {
		super(false);
		this.fieldErrors = builder.fieldErrors;
		this.errors = builder.errors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public static class Builder {
		private List<FieldError> fieldErrors = new ArrayList<>();
		private List<String> errors = new ArrayList<>();
		private MessageSource messageSource;

		public ValidationFailureResponse build() {
			return new ValidationFailureResponse(this);
		}

		public final Builder messageSource(MessageSource messageSource) {
			this.messageSource = messageSource;
			return this;
		}

		public final Builder fieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
			for (org.springframework.validation.FieldError fieldError : fieldErrors) {
				FieldError error = new FieldError(fieldError.getField(),
						this.messageSource == null ? fieldError.getCode() :
								this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
				this.fieldErrors.add(error);
			}

			return this;
		}

		public final Builder errors(List<ObjectError> objectErrors) {
			for (ObjectError objectError : objectErrors) {
				this.errors.add(messageSource == null ? objectError.getCode() :
						messageSource.getMessage(objectError, LocaleContextHolder.getLocale()));
			}

			return this;
		}

		public final Builder fieldError(String field, String message) {
			this.fieldErrors.add(new FieldError(field, messageSource == null ? message :
					messageSource.getMessage(message, null, LocaleContextHolder.getLocale())));

			return this;
		}
	}
}