let width, height, canvas, ctx, baseScaling, dynamicScalingFactor, k, isDrawMode = false, isMagnetMode = false;

export function setupCanvas(R) {
    canvas = document.getElementById("graphCanvas");
    if (!canvas) {
        throw new Error("Canvas element not found");
    }
    ctx = canvas.getContext("2d");
    setWidth(canvas.width);
    setHeight(canvas.height);
    k = 1.7; // edit this constant if you want other scale for graph
    baseScaling = width / 6;
    setDynamicScalingFactor(R);
}

export function getCanvas() {
    return canvas;
}

export function getContext() {
    return ctx;
}

export function getWidth() {
    return width;
}

export function getHeight() {
    return height;
}

export function getBaseScaling() {
    return baseScaling;
}

export function getDynamicScalingFactor() {
    return dynamicScalingFactor;
}

export function getK() {
    return k;
}

export function getGraphSetup() {
    return {
        ctx: getContext(),
        width: getWidth(),
        height: getHeight(),
        k: getK(),
        dynamicScalingFactor: getDynamicScalingFactor()
    };
}

export function getDrawModeState() {
    return isDrawMode;
}

export function getMagnetModeState() {
    return isMagnetMode;
}

export function setWidth(newWidth) {
    width = newWidth;
}

export function setHeight(newHeight) {
    height = newHeight;
}

export function setDynamicScalingFactor(R) {
    dynamicScalingFactor = getBaseScaling() * getK() / R;
}

export function setK(newK) {
    k = newK;
}

export function setDrawModeState(state) {
    isDrawMode = state;
}

export function setMagnetModeState(state) {
    isMagnetMode = state;
}

