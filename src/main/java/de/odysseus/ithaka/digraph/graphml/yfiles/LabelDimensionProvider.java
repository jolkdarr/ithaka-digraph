/*
 * Copyright 2012 Odysseus Software GmbH, Frankfurt am Main/Germany.
 */
package de.odysseus.ithaka.digraph.graphml.yfiles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import de.odysseus.ithaka.digraph.layout.LayoutDimension;
import de.odysseus.ithaka.digraph.layout.LayoutDimensionProvider;

public class LabelDimensionProvider<V> implements LayoutDimensionProvider<V> {
	private static FontMetrics getFontMetrics(Font font) {
		Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).getGraphics();
		FontMetrics metrics = graphics.getFontMetrics(font);
		graphics.dispose();
		return metrics;
	}
	
	private final LabelResolver<? super V> labels;
	private final FontMetrics metrics;
	private final Insets insets;

	public LabelDimensionProvider(LabelResolver<? super V> labels, Font font) {
		this(labels, font, new Insets(5, 5, 5, 5));
	}

	public LabelDimensionProvider(LabelResolver<? super V> labels, Font font, Insets insets) {
		this(labels, getFontMetrics(font), insets);
	}

	public LabelDimensionProvider(LabelResolver<? super V> labels, FontMetrics metrics, Insets insets) {
		this.labels = labels;
		this.metrics = metrics;
		this.insets = insets;
	}

	@Override
	public LayoutDimension getDimension(V vertex) {
		return vertex == null ? new LayoutDimension(0, 0) : new LayoutDimension(
				metrics.stringWidth(labels.getLabel(vertex)) + insets.left + insets.right,
				metrics.getHeight() + insets.top + insets.bottom);
	}
}
