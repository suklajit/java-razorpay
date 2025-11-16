package co.nz.csoft.razorpay.dto;

import java.util.List;

public class WhatsappDto {
	private String messaging_product;
	private String recipient_type;
	private String to;
	private String type;
	private Template template;

	public String getMessaging_product() {
		return messaging_product;
	}

	public void setMessaging_product(String messaging_product) {
		this.messaging_product = messaging_product;
	}

	public String getRecipient_type() {
		return recipient_type;
	}

	public void setRecipient_type(String recipient_type) {
		this.recipient_type = recipient_type;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public static class Template {
		private String name;
		private Language language;
		private List<Components> components;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Language getLanguage() {
			return language;
		}

		public void setLanguage(Language language) {
			this.language = language;
		}

		public List<Components> getComponents() {
			return components;
		}

		public void setComponents(List<Components> components) {
			this.components = components;
		}

		@Override
		public String toString() {
			return "Template [name=" + name + ", language=" + language + ", components=" + components + "]";
		}

	}

	public static class Language {
		private String code;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public static class Components {

		private String type;
		private List<Parameters> parameters;
		private String sub_type;
		private String index;

		public String getSub_type() {
			return sub_type;
		}

		public void setSub_type(String sub_type) {
			this.sub_type = sub_type;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Parameters> getParameters() {
			return parameters;
		}

		public void setParameters(List<Parameters> parameters) {
			this.parameters = parameters;
		}

		@Override
		public String toString() {
			return "Components [type=" + type + ", parameters=" + parameters + ", sub_type=" + sub_type + ", index="
					+ index + "]";
		}

		public static class Parameters {
			private String type;
			private Image image;
			private Video video;
			private String text;
			private Document document;
			

			public Document getDocument() {
				return document;
			}

			public void setDocument(Document document) {
				this.document = document;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public Image getImage() {
				return image;
			}

			public void setImage(Image image) {
				this.image = image;
			}

			public Video getVideo() {
				return video;
			}

			public void setVideo(Video video) {
				this.video = video;
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			@Override
			public String toString() {
			    return "Parameters [type=" + type
			            + ", image=" + image
			            + ", video=" + video
			            + ", document=" + document
			            + ", text=" + text + "]";
			}

		}

		private static class Image {
			private String link;

			public String getLink() {
				return link;
			}

			public void setLink(String link) {
				this.link = link;
			}

			@Override
			public String toString() {
				return "Image [link=" + link + "]";
			}

		}

		private static class Video {
			private String link;

			public String getLink() {
				return link;
			}

			public void setLink(String link) {
				this.link = link;
			}

			@Override
			public String toString() {
				return "Video [link=" + link + "]";
			}

		}
		
		public static class Document {
		    private String link;
		    private String filename;

		    public String getLink() {
		        return link;
		    }

		    public void setLink(String link) {
		        this.link = link;
		    }

		    public String getFilename() {
		        return filename;
		    }

		    public void setFilename(String filename) {
		        this.filename = filename;
		    }

		    @Override
		    public String toString() {
		        return "Document [link=" + link + ", filename=" + filename + "]";
		    }
		}


	}

	@Override
	public String toString() {
		return "WhatsappDto [messaging_product=" + messaging_product + ", recipient_type=" + recipient_type + ", to="
				+ to + ", type=" + type + ", template=" + template + "]";
	}
}
