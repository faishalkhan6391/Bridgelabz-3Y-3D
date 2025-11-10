# CSS Grid and Flexbox Layout

This document explains the concepts of **CSS Grid Layout** and **Flexbox** — two core modern CSS layout techniques used to create responsive and well-structured web designs.

---

## CSS Grid Layout

**CSS Grid Layout** is a powerful two-dimensional system that enables developers to create complex layouts using **rows and columns**. It provides precise control over spacing, alignment, and item placement, offering more flexibility than one-dimensional systems like Flexbox.

### Grid Container Properties
- **display: grid | inline-grid** — Defines a grid container and activates grid layout.
- **grid-template-columns** — Specifies the number and width of columns.
- **grid-template-rows** — Specifies the number and height of rows.
- **grid-template-areas** — Defines named layout areas.
- **column-gap / row-gap / gap** — Controls space between grid items.
- **justify-items** — Aligns items horizontally inside each cell.
- **align-items** — Aligns items vertically inside each cell.
- **place-items** — Shorthand for align-items and justify-items.
- **justify-content / align-content / place-content** — Aligns the overall grid inside its container.
- **grid-auto-rows / grid-auto-columns** — Sets the size of automatically created rows or columns.
- **grid-auto-flow** — Controls item placement (row, column, or dense).

### Grid Item Properties
- **grid-column-start / grid-column-end** — Defines where a grid item starts and ends horizontally.
- **grid-row-start / grid-row-end** — Defines where a grid item starts and ends vertically.
- **grid-column / grid-row** — Shorthand for start and end positions.
- **grid-area** — Specifies an item’s position using named areas or line numbers.
- **justify-self / align-self / place-self** — Aligns individual grid items within their cells.

---

## Flexbox in CSS

**Flexbox (Flexible Box Layout)** provides a one-dimensional layout method for aligning and distributing space among elements. It works along a single axis (row or column) and adapts easily to different screen sizes, making it ideal for modern responsive design.

### Flex Container Properties
- **flex-direction** — Defines the main axis direction (row, column, etc.).
- **justify-content** — Aligns items along the main axis.
- **align-items** — Aligns items along the cross axis.
- **flex-wrap** — Allows items to wrap into multiple lines.
- **align-content** — Aligns lines of flex items when wrapping occurs.

### Flex Item Properties
- **flex-grow** — Determines how much an item can grow relative to others.
- **flex-shrink** — Determines how much an item can shrink relative to others.
- **flex-basis** — Sets the initial size of an item.
- **flex** — Shorthand for flex-grow, flex-shrink, and flex-basis.
- **order** — Controls the visual order of items.
- **align-self** — Overrides the container’s align-items for an individual item.

---

## Key Difference Between Grid and Flexbox

| Feature | CSS Grid | Flexbox |
|----------|-----------|---------|
| Layout Type | Two-dimensional (rows and columns) | One-dimensional (row **or** column) |
| Alignment | Aligns items both horizontally and vertically | Aligns items along one axis |
| Main Usage | Large-scale layouts (pages, sections) | Small-scale UI alignment |
| Control | Precise grid-based
