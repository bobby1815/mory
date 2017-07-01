/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */


CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
 config.docType = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">';
	    config.font_defaultLabel = '나눔고딕';
	    config.font_names = '나눔고딕/nanumgothic;맑은고딕/MalgunGothic;돋움/Dotum;굴림/Gulim;바탕/Batang;궁서/Gungsuh;Arial/Arial;Comic Sans MS/Comic Sans MS;Courier New/Courier New;Georgia/Georgia;Lucida Sans Unicode/Lucida Sans Unicode;Tahoma/Tahoma;Times New Roman/Times New Roman;Trebuchet MS/Trebuchet MS;Verdana/Verdana';
	    config.fontSize_defaultLabel = '12px';
	    config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;';
	    config.language = "ko";
	    config.resize_enabled = false;
	    config.enterMode = CKEDITOR.ENTER_BR;
	    config.shiftEnterMode = CKEDITOR.ENTER_P;
	    config.startupFocus = true;
	    config.uiColor = '#eaebe7';
	    config.toolbarCanCollapse = false;
	    config.menu_subMenuDelay = 0;
	    config.width ='100%';
	    config.height ='200';
	    config.allowedContent = true;
	    config.enterMode = CKEDITOR.ENTER_P;
	    config.shiftEnterMode = CKEDITOR.ENTER_P;
	    config.filebrowserUploadUrl='/ckeditor/upload.jsp?';
		config.filebrowserImageUploadUrl = '/ckeditor/upload.jsp';
		config.forceSimpleAmpersand = true;
	    config.toolbar = [
	        ['Source','-','Save','NewPage','Preview','-','Templates'],
	        ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
	        ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	        ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
	        '/',
	        ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	        ['Link','Unlink','Anchor'],
	        ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	        '/',
	        ['Styles','Format','Font','FontSize'],
	        ['TextColor','BGColor'],
	        ['Maximize', 'ShowBlocks','-','About']
	
	        
	   ];
	
};
