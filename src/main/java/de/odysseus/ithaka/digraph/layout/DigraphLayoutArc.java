/*
 * Copyright 2012 Odysseus Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.odysseus.ithaka.digraph.layout;

public interface DigraphLayoutArc<V,E> {
	/**
	 * @return original edge data
	 */
	public E getEdge();

	/**
	 * @return start point
	 */
	public DigraphLayoutPoint getStartPoint();

	/**
	 * @return source node
	 */
	public DigraphLayoutNode<V> getSource();

	/**
	 * @return end point
	 */
	public DigraphLayoutPoint getEndPoint();

	/**
	 * @return target node
	 */
	public DigraphLayoutNode<V> getTarget();

	/**
	 * @return bend points
	 */
	public Iterable<DigraphLayoutPoint> getBendPoints();


	public boolean isFeedback();
}
