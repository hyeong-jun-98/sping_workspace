/**
 * 웹 사이트에서 자주 사용되는 스크립트 모음
 */
 
 function getExt(path) {
	index = path.lastIndexOf(".");
	return path.substring(index+1, path.length)
}