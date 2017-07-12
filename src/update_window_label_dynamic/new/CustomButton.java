package com.magna.xmsystem.xmenu.ui.parts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The Class CustomButton.
 * 
 * @author subash.janarthanan
 * 
 */
public class CustomButton extends Composite {

	/** The default BG color. */
	final Color defaultBGColor;

	/** The default FG color. */
	final Color defaultFGColor;

	/** The default mouse down color. */
	final Color defaultMouseDownBGColor;

	/** The default mouse down FG color. */
	final Color defaultMouseDownFGColor;

	/** The mouse hover BGFG over color. */
	final Color defaultMouseEnterBGColor;

	/** The mouse hover FG over color. */
	final Color defaultMouseEnterFGColor;
	
	/** The default mouse up BG color. */
	final Color defaultMouseUpBGColor;

	/** The default mouse up FG color. */
	final Color defaultMouseUpFGColor;

	/** The default font. */
	private Font defaultFont;
	
	/** The right arrow image. */
	final Image rightArrowImage;
			
	/** The default arrow. */
	private boolean isArrow = false;

	/** The left label. */
	private CLabel leftLabel;

	/** The right label. */
	private CLabel rightLabel;

	/** The text. */
	private String text = "";

	/** The image. */
	private Image image;

	/** The custom font. */
	private Font font;

	/** The bg color. */
	private Color customBGColor;

	/** The fg color. */
	private Color customFGColor;
	
	/** The custom mouse hover BG color. */
	private Color customMouseEnterBGColor;
	
	/** The custom mouse hover FG color. */
	private Color customMouseEnterFGColor;
	
	/** The custom mouse up BG color. */
	private Color customMouseUpBGColor;
	
	/** The custom mouse up FG color. */
	private Color customMouseUpFGColor;
	
	/** The custom mouse up BG color. */
	private Color customSelectionBGColor;

	/** The custom mouse up FG color. */
	private Color customSelectionFGColor;
	
	/** The menu. */
	private Menu menu;

	/** The custom selection font. */
	private Font customSelectionFont;
	
	/** The custom mouse hover font. */
	private Font customMouseHoverFont;
	
	/** The tool tip text. */
	private String toolTipText;

	/** The resource manager. */
	private ResourceManager resourceManager; 
	
	/** The default image. */
	private String defaultRightArrowImage = "icons/16x16/rightarrow.png";

	/**
	 * Instantiates a new custom button.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public CustomButton(Composite parent, int style) {
		super(parent, style | SWT.BORDER);
		this.resourceManager = new LocalResourceManager(JFaceResources.getResources());
		this.rightArrowImage = getSavedImage(defaultRightArrowImage);
		this.defaultBGColor = getSavedColor(226, 226, 226);				// Silver
		this.defaultFGColor = getSavedColor(0, 0, 0);					// black
		this.defaultMouseDownBGColor = getSavedColor(153, 204, 255);	//
		this.defaultMouseDownFGColor = getSavedColor(153, 204, 255);			// black
		this.defaultMouseEnterBGColor = getSavedColor(204, 229, 255);	//
		this.defaultMouseEnterFGColor = getSavedColor(204, 229, 255);			// black
		this.defaultMouseUpBGColor = getSavedColor(226, 226, 226);
		this.defaultMouseUpFGColor = getSavedColor(226, 226, 226);
		//this.defaultFont = getSavedFont("Calibri", 10, SWT.NORMAL);
		init(parent);
		setDefaultStyles();
		initListeners();
	}

	/**
	 * Inits the.
	 *
	 * @param parent the parent
	 */
	private void init(Composite parent) {
		final GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		gridLayout.marginTop = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		this.setLayout(gridLayout);
		
		GridData lblGridData = new GridData(SWT.RIGHT, SWT.FILL, true, false);
		leftLabel = new CLabel(this, SWT.NONE);
		rightLabel = new CLabel(this, SWT.NONE);
		rightLabel.setLayoutData(lblGridData);
	}
	
	/**
	 * Sets the default.
	 */
	private void setDefaultStyles() {
		if (customBGColor == null) {
			setBackground(defaultBGColor);
		} else {
			setBackground(customBGColor);
		}

		if (customFGColor == null) {
			setForeground(defaultFGColor);
		} else {
			setForeground(customFGColor);
		}
	}

	/**
	 * Inits the listeners.
	 */
	private void initListeners() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				setBackgroundMouseUp(defaultMouseUpBGColor);
				setForegroundMouseUp(defaultMouseUpFGColor);
			}

			@Override
			public void mouseDown(MouseEvent event) {
				setBackgroundMouseDown(defaultMouseDownBGColor);
				setForegroundMouseDown(defaultMouseDownFGColor);
			}
		});

		this.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseHover(MouseEvent event) {
				setBackgroundMouseEnter(defaultMouseEnterBGColor);
				setForegroundMouseEnter(defaultMouseEnterFGColor);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				setDefaultStyles();
			}
		});
	}
	
	private void setForegroundMouseEnter(Color defaultMouseHoverFGColor) {
		this.customMouseEnterFGColor = defaultMouseHoverFGColor;
		super.setBackground(this.customMouseEnterFGColor);
		leftLabel.setBackground(this.customMouseEnterFGColor);
		rightLabel.setBackground(this.customMouseEnterFGColor);
	}

	private void setBackgroundMouseEnter(Color defaultMouseHoverBGColor) {
		this.customMouseEnterBGColor = defaultMouseHoverBGColor;
		super.setBackground(this.customMouseEnterBGColor);
		leftLabel.setBackground(this.customMouseEnterBGColor);
		rightLabel.setBackground(this.customMouseEnterBGColor);
	}
	
	private void setForegroundMouseUp(Color defaultMouseUpFGColor) {
		this.customMouseUpFGColor = defaultMouseUpFGColor;
		super.setBackground(this.customMouseUpFGColor);
		leftLabel.setBackground(this.customMouseUpFGColor);
		rightLabel.setBackground(this.customMouseUpFGColor);
	}

	private void setBackgroundMouseUp(Color defaultMouseUpBGColor) {
		this.customMouseUpBGColor = defaultMouseUpBGColor;
		super.setBackground(this.customMouseUpBGColor);
		leftLabel.setBackground(this.customMouseUpBGColor);
		rightLabel.setBackground(this.customMouseUpBGColor);
	}
	
	private void setForegroundMouseDown(Color defaultMouseDownFGColor) {
		this.customSelectionFGColor = defaultMouseDownFGColor;
		super.setBackground(this.customSelectionFGColor);
		leftLabel.setBackground(this.customSelectionFGColor);
		rightLabel.setBackground(this.customSelectionFGColor);
	}

	private void setBackgroundMouseDown(Color defaultMouseDownBGColor) {
		this.customSelectionBGColor = defaultMouseDownBGColor;
		super.setBackground(this.customSelectionBGColor);
		leftLabel.setBackground(this.customSelectionBGColor);
		rightLabel.setBackground(this.customSelectionBGColor);
	}
	
	/**
	 * Sets the selection color.
	 *
	 * @param color the new selection color
	 */
	public void setSelectionBGColor(final Color color){
		this.customSelectionBGColor = color;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				setBackgroundMouseDown(customSelectionBGColor);
			}
		});
		this.redraw();
		this.update();
	}
	
	/**
	 * Sets the selection FG color.
	 *
	 * @param color the new selection FG color
	 */
	public void setSelectionFGColor(final Color color){
		this.customSelectionFGColor = color;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				setForegroundMouseDown(customSelectionFGColor);
			}
		});
	}
	
	/**
	 * Sets the selection font.
	 *
	 * @param font the new selection font
	 */
	public void setSelectionFont(final Font font){
		this.customSelectionFont = font;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				setSelectionFonts(customSelectionFont);
			}
		});
	}
	
	/**
	 * Sets the mouse hover color.
	 *
	 * @param color the new mouse hover color
	 */
	public void setMouseEnterBGColor(final Color color){
		this.customMouseEnterBGColor = color;
		this.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent event) {
				setBackgroundMouseEnter(customMouseEnterBGColor);
			}
		});
	}
	
	/**
	 * Sets the mouse hover FG color.
	 *
	 * @param color the new mouse hover FG color
	 */
	public void setMouseEnterFGColor(final Color color){
		this.customMouseEnterFGColor = color;
		this.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent event) {
				setForegroundMouseEnter(customMouseEnterFGColor);
			}
		});
	}
	
	/**
	 * Sets the mouse hover font.
	 *
	 * @param font the new mouse hover font
	 */
	public void setMouseEnterFont(final Font font){
		this.customMouseHoverFont = font;
		this.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent event) {
				setMouseEnterFonts(customMouseHoverFont);
			}
		});
	}
	
	private void setMouseEnterFonts(Font customMouseHoverFont) {
		this.customMouseHoverFont = customMouseHoverFont;
		super.setFont(this.customMouseHoverFont);
		leftLabel.setFont(this.customMouseHoverFont);		
	}
	

	private void setSelectionFonts(Font customSelectionFont) {
		this.customSelectionFont = customSelectionFont;
		super.setFont(this.customSelectionFont);
		leftLabel.setFont(this.customSelectionFont);
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(final Image image) {
		//this.image = image;
		if(image != null){
			this.leftLabel.setImage(image);
		}
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(final String text) {
		this.text = text;
		if (this.text != null) {
			this.leftLabel.setText(this.text);
		}
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the arrow.
	 *
	 * @param value the new arrow
	 */
	public void setArrow(final boolean value) {
		this.isArrow = value;
		if (isArrow) {
			rightLabel.setImage(rightArrowImage);
		}
	}

	/**
	 * Checks if is arrow.
	 *
	 * @return true, if is arrow
	 */
	public boolean isArrow() {
		return isArrow;
	}

	private Color getSavedColor(int r, int g, int b) {
		final String colorString = "COLOR:" + r + "-" + g + "-" + b;
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		if (!colorRegistry.hasValueFor(colorString)) {
			colorRegistry.put(colorString, new RGB(r, g, b));
		}
		return colorRegistry.get(colorString);
	}

	private Font getSavedFont(String fontName, int fontSize, int fontStyle) {
		final String fontString = "FONT:" + fontName + "-" + fontSize + "-" + fontStyle;
		FontRegistry fontRegistry = JFaceResources.getFontRegistry();
		if (!fontRegistry.hasValueFor(fontString)) {
			fontRegistry.put(fontString, new FontData[] { new FontData(fontName, fontSize, fontStyle) });
		}
		return fontRegistry.get(fontString);
	}
	
	
	private Image getSavedImage(String pathString) {				
		ImageRegistry imageRegistry = JFaceResources.getImageRegistry();
		Image image = imageRegistry.get(pathString);
		if (image == null) {
			final Bundle bundle = FrameworkUtil.getBundle(this.getClass());
			ImageDescriptor imageDescriptor = null;
			URL url = FileLocator.find(bundle, new Path(pathString), null);
			if (url == null) {
				try {
					url = (new File(pathString)).toURI().toURL();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			imageDescriptor = ImageDescriptor.createFromURL(url);
			image = resourceManager.createImage(imageDescriptor);
			imageRegistry.put(pathString, image);
		} 
		return image;
	}

	@Override
	public void addMouseListener(MouseListener listener) {
		super.addMouseListener(listener);
		leftLabel.addMouseListener(listener);
		rightLabel.addMouseListener(listener);
	}

	@Override
	public void addMouseTrackListener(MouseTrackListener listener) {
		super.addMouseTrackListener(listener);
		leftLabel.addMouseTrackListener(listener);
		rightLabel.addMouseTrackListener(listener);
	}

	@Override
	public void addFocusListener(FocusListener listener) {
		super.addFocusListener(listener);
		leftLabel.addFocusListener(listener);
		rightLabel.addFocusListener(listener);
	}

	@Override
	public void setBackground(final Color color) {
		this.customBGColor = color;
		super.setBackground(color);
		this.leftLabel.setBackground(color);
		this.rightLabel.setBackground(color);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setForeground(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForeground(final Color color) {
		this.customFGColor = color;
		super.setForeground(this.customFGColor);
		leftLabel.setForeground(this.customFGColor);
		rightLabel.setForeground(this.customFGColor);
	}

	/**
	 * Sets the focus to button.
	 */
	public void setFocusToButton() {
		super.setFocus();
		leftLabel.setFocus();
		rightLabel.setFocus();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(final Font font) {
		this.font = font;
		super.setFont(this.font);
		leftLabel.setFont(this.font);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setMenu(org.eclipse.swt.widgets.Menu)
	 */
	@Override
	public void setMenu(final Menu menu) {
		this.menu = menu;
		super.setMenu(this.menu);
		rightLabel.setMenu(this.menu);
		leftLabel.setMenu(this.menu);
	}

	/**
	 * Gets the default BG color.
	 *
	 * @return the default BG color
	 */
	public Color getDefaultBGColor() {
		return defaultBGColor;
	}

	/**
	 * Gets the default FG color.
	 *
	 * @return the default FG color
	 */
	public Color getDefaultFGColor() {
		return defaultFGColor;
	}

	/**
	 * Gets the default font.
	 *
	 * @return the default font
	 */
	public Font getDefaultFont() {
		return defaultFont;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Control#getFont()
	 */
	public Font getFont() {
		return font;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#getMenu()
	 */
	public Menu getMenu() {
		return menu;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setToolTipText(java.lang.String)
	 */
	@Override
	public void setToolTipText(final String string) {
		this.toolTipText = string;
		super.setToolTipText(this.toolTipText);
		leftLabel.setToolTipText(this.toolTipText);
		rightLabel.setToolTipText(this.toolTipText);
	}
	
	/**
	 * Gets the tool tiptext.
	 *
	 * @return the tool tiptext
	 */
	public String getToolTiptext(){
		return this.toolTipText;
	}
}
