/**
 * The object ControlManager is used to control form inputs and to display a message in a banner to inform users.
 */

ControlManager.INFO = 1;
ControlManager.CONF = 2;
ControlManager.WARN = 3;
ControlManager.ALERT = 4;

function ControlManager() {
	var majorMessageType = 0;
	var nbPerType = new Array();
	var tabMessage = new Array();
	var messages = null;
	var tabTempWarn = new Array();
	var tabWarn = new Array();
	
	/**
	 * setter of the messages list
	 * 
	 * @param lstMessages
	 */
	this.setMessages = function setMessages(lstMessages) {
		messages = lstMessages;
	};

	/**
	 * 
	 * @param type :
	 *            message type
	 * @returns the label to construct the class CSS name
	 */
	function fnLabel(type) {
		var label = null;
		if (type == ControlManager.INFO)
			label = "info";
		if (type == ControlManager.CONF)
			label = "conf";
		if (type == ControlManager.WARN)
			label = "warn";
		if (type == ControlManager.ALERT)
			label = "error";
		return label;
	}
	/**
	 * Prepare the message to return
	 * 
	 * @param objMessage :
	 *            message code, [] additional variables
	 * @returns : string to display
	 */
	function prepareMessage(objMessage) {
		if (messages == null) {
			messages = new Array();
		}
		var str = messages[objMessage.code];
		if (typeof (str) == 'undefined') {
			str = "code non défini (" + objMessage.code + ") $1 $2 ...";
		}
		if (typeof (objMessage.tabVar) == 'undefined') {
			return str;
		} else {
			for (var i = objMessage.tabVar.length; i > 0; i--) {
				str = str.replace("$" + i, objMessage.tabVar[i - 1]);
			}
		}
		return str;
	}

	
	function bannerMessage() {
		if (bannerMessage.arguments.length == 3) {
			bannerMessage_Var3.apply(this, bannerMessage.arguments);
		} else {
			bannerMessage_Var1.apply(this, bannerMessage.arguments);
		}

	}

	/**
	 * 
	 * @param type
	 * @param message
	 * @param addVariable
	 */
	function bannerMessage_Var3(type, message, addVariable) {
		nbPerType[type]++;
		if (type > majorMessageType) {
			majorMessageType = type;
			if (majorMessageType == ControlManager.INFO)
				txtImage = "message-info";
			if (majorMessageType == ControlManager.CONF)
				txtImage = "message-confirmation";
			if (majorMessageType == ControlManager.WARN)
				txtImage = "message-warn";
			if (majorMessageType == ControlManager.ALERT)
				txtImage = "not-ok";
			$("#logoBanner").html(
					"<img alt='message-error' src='/img/pictogrammes/picto-"
							+ txtImage + ".png' />");

			$("#banner").show();
		}
		if (type == ControlManager.CONF) {
			$("#bannerConf").html(prepareMessage({
				code : message,
				tabVar : addVariable
			}));
		} else if (type == ControlManager.ALERT) {
			$("#bannerAlert").html(prepareMessage({
				code : message,
				tabVar : addVariable
			}));
		}
	}

	/**
	 * Banner management
	 * 
	 * @param type 
	 */
	function bannerMessage_Var1(type) {
		nbPerType[type]++;
		if (type > majorMessageType) {
			majorMessageType = type;
			if (majorMessageType == ControlManager.INFO)
				txtImage = "message-info";
			if (majorMessageType == ControlManager.CONF)
				txtImage = "message-confirmation";
			if (majorMessageType == ControlManager.WARN)
				txtImage = "message-warn";
			if (majorMessageType == ControlManager.ALERT)
				txtImage = "not-ok";
			$("#logoBanner").html(
					"<img alt='message-error' src='/img/pictogrammes/picto-"
							+ txtImage + ".png' />");

			$("#banner").show();
		}
		if (type == ControlManager.ALERT) {
			$("#bannerAlert").html(prepareMessage({
				code : "lblErrBanner",
				tabVar : [ nbPerType[type] ]
			}));
		} else if (type == ControlManager.WARN) {
			$("#bannerWarn").html(prepareMessage({
				code : "lblWarnBanner",
				tabVar : [ nbPerType[type] ]
			}));
		}
	}

			/**
			 * Initialization (and reset) of controlManager
			 * Delete the eventual previous errors and hide the banner
			 */
			this.reset = function reset(idBanner) {
				if (!idBanner) {
					idBanner = "content";
				}
				if (!$("#" + idBanner)
						.text()
						.match(
								"/^<div id='banner' class='banner'><div id='bannerMessage' class='bannerMessage'><div id='bannerLogo' class='bannerLogo'></div><div id='bannerAlert'></div><div id='bannerWarn'></div><div id='bannerConf'></div></div></div>/")) {
					$("#banner").remove();
					$("#" + idBanner)
							.prepend(
									"<div id='banner' class='banner'><div id='bannerMessage' class='bannerMessage'><div id='bannerLogo' class='bannerLogo'></div><div id='bannerAlert'></div><div id='bannerWarn'></div><div id='bannerConf'></div></div></div>");
				}

				for (var i = 0; i < ControlManager.ALERT; i++) {
					nbPerType[i + 1] = 0;
				}
				// Messages resets
				for (var i = 0; i < tabMessage.length; i++) {
					var label = fnLabel(tabMessage[i].type);
					if ($("#" + tabMessage[i].id).is("table")) {
						$("#" + label + "Table" + tabMessage[i].id).remove();
					} else if ($("#" + tabMessage[i].id).is("tr")) {
						$("#" + label + "" + tabMessage[i].id).remove();
					} else {
						var elt = $("#" + tabMessage[i].id).closest("td");
						if (typeof (elt.html()) == 'undefined') {
							elt = $("#" + tabMessage[i].id).closest("p");
							elt.children("span").removeClass(label);
						} else {
							elt.removeClass(label + "Td");
							elt.children("br").remove();
						}
					}
					$("#" + tabMessage[i].id).removeClass(label);
					$("#lbl" + label + "" + tabMessage[i].id).remove();
					$("#logo" + label + "" + tabMessage[i].id).remove();
				}

				// The warnings go in the temporary array tabTempWarn and tabWarn is reset
				tabTempWarn = tabWarn;
				tabWarn = new Array();
				$("#bannerMessage").children("div").html("");
				majorMessageType = 0;
				$("#banner").hide();
			},
			/**
			 * 
			 * @returns {Boolean} true if there is no error or not confirmed warning, false otherwise
			 */
			this.hasNoError = function hasNoError() {
				var noError = true;
				// Errors
				if (nbPerType[ControlManager.ALERT] > 0) {
					noError = false;
				} else {
					noError = true;
				}

				// Warnings
				for ( var i in tabWarn) {
					var test = false;
					for ( var j in tabTempWarn) {
						if (tabWarn[i].id == tabTempWarn[j].id
								&& tabWarn[i].message == tabTempWarn[j].message)
							test = true;
					}
					if (!test) {
						noError = false;
					}
				}
				return noError;
			},

			/**
			 * Add a message in the content page (info,
			 * confirmation, warning, error)
			 * 
			 * @param id :
			 *            null if the id concern the all page
			 * @param type 
			 * @param message :
			 *            Message code (bannerMessage.js) to display according the id
			 *           
			 * @param addVariable :
			 *            Table of variables completing the message
			 */
			this.add = function add(id, type, message, addVariable) {
				tabMessage[tabMessage.length] = {
					type : type,
					message : message,
					id : id
				};

				if (type == ControlManager.WARN) {
					tabWarn[tabWarn.length] = {
						message : message,
						id : id
					};
				}

				if (id != "") {
					var label = fnLabel(type);
					if (typeof $("#div" + label + "" + id).html() != 'undefined') {
						var elt = $("#div" + label + "" + id);
						elt.append("<span id='logo" + label + "" + id
								+ "' class='msg-" + label + "'></span>");
						elt.append("<span id='lbl" + label + "" + id
								+ "' class='legend " + label + "'>"
								+ prepareMessage({
									code : message,
									tabVar : addVariable
								}) + "</span>");
						$("#" + id).addClass(label);
					}

					else if ($("#" + id).is("tr")) {
						$("#" + id)
								.after(
										"<tr id='"
												+ label
												+ ""
												+ id
												+ "'><td colspan='"
												+ $("#" + id).children("td").length
												+ "'><div style='text-align:center'><span id='logo"
												+ label + "" + id
												+ "' class='msg-" + label
												+ "'></span><span id='lbl"
												+ label + "" + id
												+ "' class='	 " + label
												+ "'>" + prepareMessage({
													code : message,
													tabVar : addVariable
												}) + "</span></div></td></tr>");
					}

					else if ($("#" + id).is("table")) {
						$("#" + id).after(
								"<p class='tableError' id='" + label
										+ "Table" + id + "'><span id='logo"
										+ label + "" + id + "' class='msg-"
										+ label + "'></span><span id='lbl"
										+ label + "" + id + "' class='"
										+ label + "'>" + prepareMessage({
											code : message,
											tabVar : addVariable
										}) + "</span></p>");
					} else {
						var elt = $("#" + id).closest("td");
						if (typeof (elt.html()) == 'undefined') {
							elt = $("#" + id).closest("p");
							elt.addClass(label);
						} else {
							elt.addClass(label + "Td");
							elt.append("<br />");
						}
						elt.append("<span id='logo" + label + "" + id
								+ "' class='msg-" + label + "'></span>");
						elt.append("<span id='lbl" + label + "" + id
								+ "' class='legend " + label + "'>"
								+ prepareMessage({
									code : message,
									tabVar : addVariable
								}) + "</span>");
						$("#" + id).addClass(label);
					}
					bannerMessage(type);
				} else {
					bannerMessage(type, message, addVariable);
				}
			};
}

/**
 * Vérification de base d'un string
 * 
 * @param id :
 *            id de l'input à tester
 * @param lgMini :
 *            0 si non obligatoire, sinont taille minimum défini
 * @param lgMaxi :
 *            taille maximum défini
 */
String.check = function String_check(id, lgMini, lgMaxi) {
	if (($("#" + id).val() == null || $("#" + id).val() == "") && lgMini != 0) {
		controlManager.add(id, ControlManager.ALERT, "errObligatoire");
		return false;
	} else if (!($("#" + id).val().length >= lgMini && $("#" + id).val().length <= lgMaxi)) {
		if (lgMini == lgMaxi) {
			controlManager.add(id, ControlManager.ALERT,
					"errTailleMinEgalMax", [ lgMini ]);
		} else {
			controlManager.add(id, ControlManager.ALERT, "errTaille", [
					lgMini, lgMaxi ]);
		}

		return false;
	}
	return true;
};

